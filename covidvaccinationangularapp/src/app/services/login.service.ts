import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AbstractControl, AsyncValidatorFn, ValidationErrors } from '@angular/forms';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url:string="http://localhost:7000/login";

  constructor(private http:HttpClient) { }


  validateUser(credentails:any){

   return this.http.post(this.url+"/authenticate",credentails)
  }
    

  registerUser(user:any){
    return this.http.post(this.url+"/registerUser",user);
   
  }    
   
  isUserNameAvailable(username:any){
     return this.http.get(this.url+"/checkUser/"+username);
   
  }


   //to check anyone is logged in or not
  isLoggedIn(){
    if(sessionStorage.getItem("role"))
     return true;
    else
     return false;
  }

  //whether loggedIn person is Doctor or not
  isAdminLoggedIn(){
   if(sessionStorage.getItem("role") === "Doctor")
     return true;
   else
     return false;
  }


  usernameValidator(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.isUserNameAvailable(control.value).pipe(
        map(res => {
          // if res is true, username exists, return true
          return res ? { usernameExists: true } : null;
          // Return null if there is no error
        })
      );
    };
  }
  

}
