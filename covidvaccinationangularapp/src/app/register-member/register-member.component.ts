import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MemberService } from '../services/member.service';

@Component({
  selector: 'app-register-member',
  templateUrl: './register-member.component.html',
  styleUrls: ['./register-member.component.css']
})
export class RegisterMemberComponent implements OnInit {

  message:any;
  
  myregistrationForm:any;

  constructor(private memberService:MemberService,private router:Router) { }

  ngOnInit(): void {

    this.myregistrationForm=new FormGroup({

      name:new FormControl("",[Validators.required,Validators.maxLength(12)]),
      address:new FormControl("",[Validators.required,Validators.minLength(3)]),
      email:new FormControl("",[Validators.required,Validators.email]),
      salary:new FormControl("",[Validators.required,Validators.min(5000)])

    });

  }

  
  





}
