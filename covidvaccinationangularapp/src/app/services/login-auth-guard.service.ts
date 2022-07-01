import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class LoginAuthGuardService implements CanActivate{

  constructor(private router:Router,private loginService:LoginService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

    if(this.loginService.isLoggedIn())
      return true;
    else{
      this.router.navigate(["/login"]);
      return false;
    }

  }
}
