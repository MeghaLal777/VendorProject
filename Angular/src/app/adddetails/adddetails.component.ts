import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router, ActivatedRoute } from '@angular/router';
import { VendorPerson } from '../vendorperson';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-adddetails',
  templateUrl: './adddetails.component.html',
  styleUrls: ['./adddetails.component.scss']
})
export class AdddetailsComponent implements OnInit {

  vendors: VendorPerson[];
  vendor = new VendorPerson();

  constructor(private route: ActivatedRoute,private _router: Router, private _vendorservice:VendorService,private _authservice: AuthService) { }

  ngOnInit() {

    this.route.params.subscribe(params => this.getVendorById(params['vendorId']));
  }

  getVendorById(vendorId: number) {
    console.log("vendor Id " + vendorId);
    this._vendorservice.getVendorById(vendorId)
      .subscribe((searchData) => {
        this.vendor = searchData;
        console.log(searchData);
      }, (error) => {
        console.log(error);
      });
  }

  saveVendor(): void {
    console.log(this.vendor);
    this._vendorservice.addVendor(this.vendor)
      .subscribe((response) => {
        console.log(response);
        this._router.navigate(['viewvendor']);
      }, (error) => {
        console.log(error);
      });
  }


  back(): void {
    this._router.navigate(['viewvendor']);
  }

  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }

}
