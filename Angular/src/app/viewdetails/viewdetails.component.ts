import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VendorService } from '../vendor.service';
import { VendorPerson } from '../vendorperson';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-viewdetails',
  templateUrl: './viewdetails.component.html',
  styleUrls: ['./viewdetails.component.scss']
})
export class ViewdetailsComponent implements OnInit {

  vendors: VendorPerson[];
  vendor = new VendorPerson();
  search: String;

  message: string;

  constructor(private _router: Router, private _vendorservice:VendorService,private _authservice: AuthService) { }

  ngOnInit() {

    this.getAllVendors();
  }

  getAllVendors(): void {
    this._vendorservice.getAllVendors()
      .subscribe((vendorData) => {
        this.vendors = vendorData;
        console.log(vendorData);
      }, (error) => {
        console.log(error);
      });

  }

  searchVendor(search: string) {
    console.log(search);
    this._vendorservice.searchVendor(search).subscribe((response) => {
      this.vendors = response

      if (search != null) {
        console.log(response);
        if (response.length == 0) {
          this.message = "Not Found";
          console.log(this.message);
          this.search = undefined;
        }
        else {
          this.vendors = response
          console.log(this.vendors);
          this.search = undefined;
          this.message = undefined;
        }
      }
      else {
        this.getAllVendors();
      }
    }, (error) => {
      console.log(error);
    });
  }


  view(): void {
    this.getAllVendors();
    this.search = undefined;
    this.message = undefined;
  }

  disableVendor(vendorId: number): void {
    console.log(vendorId);
    this._vendorservice.disableVendor(vendorId)
      .subscribe((response) => {
        //console.log(response);
        this.vendor = response
        console.log(this.vendor);
        this.getAllVendors();
      }, (error) => {
        console.log(error);
      });
  }

  edit(vendorId: number): void {
    console.log(vendorId);
    this._router.navigate(['addvendor/'+vendorId]);
  }

  add(): void {
    this._router.navigate(['addvendor']);
  }

  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }
}
