import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router,private loginService:LoginService) { }

  ngOnInit(): void {
  }

  login(credentials:any){


    this.loginService.validateUser(credentials).subscribe({ next: (resp:any)=>{
      console.log(resp);
          
          sessionStorage.setItem("role",resp.role);
          sessionStorage.setItem("loginName",resp.username);  
          this.router.navigate(["listMember",resp.username]);
  
    },
    
    
  error: err=>{
          
      alert(err.error.message + ": "+ err.status);
    }
    
    });
  }
  
}
