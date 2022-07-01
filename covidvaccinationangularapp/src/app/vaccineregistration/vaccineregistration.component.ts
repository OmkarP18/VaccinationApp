import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VaccineregistrationService } from '../services/vaccineregistration.service';

@Component({
  selector: 'app-vaccineregistration',
  templateUrl: './vaccineregistration.component.html',
  styleUrls: ['./vaccineregistration.component.css']
})
export class VaccineregistrationComponent implements OnInit {


  constructor(private router:Router,private vaccineregistrationservice:VaccineregistrationService) { }

  ngOnInit(): void {

}
  fun1(){
    alert("Succesfully Registered");
  }

}