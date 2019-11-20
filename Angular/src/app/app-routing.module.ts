import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewdetailsComponent } from './viewdetails/viewdetails.component';
import { AdddetailsComponent } from './adddetails/adddetails.component';


const routes: Routes = [
  { path: '', component:LoginComponent},
  { path: 'login', component:LoginComponent},

 { path: 'viewvendor', component:ViewdetailsComponent},
  { path: 'addvendor', component:AdddetailsComponent},
  
  { path: 'addvendor/:vendorId', component:AdddetailsComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


