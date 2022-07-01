import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  msg:any;
  registrationForm:any;
  user:any;

  constructor(private loginservice: LoginService, private router:Router) {

    this.registrationForm=new FormGroup({

      username:new FormControl("",Validators.required,loginservice.usernameValidator()),
      password:new FormControl("",Validators.required),
      repassword:new FormControl("",Validators.required),
      role:new FormControl("",Validators.required)

  });

   }

  ngOnInit(): void {
  }

  
  register(){
    if(this.registrationForm.valid){

       this.loginservice.registerUser(this.registrationForm.value)

       .subscribe( resp =>{
         
          this.user=resp;
          alert(this.user.username+" Registerd Sucessfully");
          this.router.navigate(["/login"]);

       }, err=>{
         this.msg=err.error.message;
         
       });
    }
    else
      this.msg="Invalid Form Input";
  }

}


 

