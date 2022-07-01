import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from '../services/login.service';
import { MemberService } from '../services/member.service';

@Component({
  selector: 'app-list-member',
  templateUrl: './list-member.component.html',
  styleUrls: ['./list-member.component.css']
})
export class ListMemberComponent implements OnInit {
  
  loginname:any;
  members:any;
  errorMessage:any;
  role = "User";

  constructor(private activatedRoute:ActivatedRoute,private loginService:LoginService) { }

  ngOnInit(): void {

  }
   


}