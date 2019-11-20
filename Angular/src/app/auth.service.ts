import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Login } from './login';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  formData: Login;
  constructor(private router: Router, private _httpService: HttpClient) { }

  logout() :void 
  {    
    localStorage.setItem('isLoggedIn','false');    
    localStorage.removeItem('token');  
    localStorage.removeItem('tokenRoleId');
    this.router.navigate(['/login']);   
  } 


  getRole(formData: any): any {
    return this._httpService.get<Login>(environment.APIUrl + '/login/' + formData.username + '/' + formData.password);

  }
}
