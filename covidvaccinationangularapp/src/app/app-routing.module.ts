import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentComponent } from './appointment/appointment.component';
import { ListMemberComponent } from './list-member/list-member.component';
import { LoginComponent } from './login/login.component';

import { RegisterMemberComponent } from './register-member/register-member.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { VaccineregistrationComponent } from './vaccineregistration/vaccineregistration.component';

const routes: Routes = [

{path:"",redirectTo:"login",pathMatch:"full"},
{path:"login",component:LoginComponent},
{path:"signup",component:SignUpComponent},
{path:"registerMember",component:RegisterMemberComponent},
{path:"listMember/:name",component:ListMemberComponent},
{path:"appointment",component:AppointmentComponent},
{path:"vaccineRegitration",component:VaccineregistrationComponent},
{path:"**",redirectTo:"login",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
