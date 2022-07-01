import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginService } from './services/login.service';
import { ListMemberComponent } from './list-member/list-member.component';
import { RegisterMemberComponent } from './register-member/register-member.component';
import { AppointmentComponent } from './appointment/appointment.component'
import { MemberService } from './services/member.service';
import { VaccineregistrationComponent } from './vaccineregistration/vaccineregistration.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignUpComponent,
    ListMemberComponent,
    RegisterMemberComponent,
    AppointmentComponent,
    VaccineregistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [LoginService,MemberService],
  bootstrap: [AppComponent]
})
export class AppModule { }
