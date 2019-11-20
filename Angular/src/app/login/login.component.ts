import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';
import { Login } from '../login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login = new Login();

  constructor(private router: Router, private _authservice: AuthService) { }

  ngOnInit() {

    this.resetForm()
  }
  resetForm(form?: NgForm) {
    if (form != null)
      form.resetForm();

  this._authservice.formData = {

    userName: '',
    password: '',
    userId: null
  
  }
}

OnSubmit(form: NgForm) {
  console.log("My form : " + form);
  this.loginUser(form);
}
loginUser(form: NgForm) {
  //if((this.sessionTokenUserName==null) && (this.sessionTokenRoleID==null))
  //{
  console.log(form.value);
  this._authservice.getRole(form.value).subscribe((userData) => {
  this.login = userData;
    console.log(this.login);
    var username = this.login.userName;
    var password = this.login.password;
    
    
    if (this.login.userId == 100)
     {
     
      this.router.navigate(['/viewvendor']);
     }
     else{

      this.router.navigate(['/viewvendor']);

     }
   
    
    }, (error) => {
      console.log(error);
    });
  }
}
