import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VaccineregistrationService {

  
  private url:string="http://localhost:7000/vaccineregistration";

  constructor(private http:HttpClient) { }
  addVaccineRegistration(vreg:any){

    return this.http.post(this.url+"/addvaccineregistration",vreg)
   }
  
   updateVaccineRegistration(vreg:any){

    return this.http.post(this.url+"/updatevaccineregistration",vreg)
   }
}
   
