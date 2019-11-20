import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { VendorPerson } from './vendorperson';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VendorService {

  constructor(private _httpServce: HttpClient) { }

  getAllVendors(): Observable<VendorPerson[]> {
    return this._httpServce.get<VendorPerson[]>(environment.APIUrl + '/vendor/vendordetails');
  }

  searchVendor(search: string): Observable<VendorPerson[]> {
    return this._httpServce.get<VendorPerson[]>(environment.APIUrl + '/vendor/' + search);
  }

  disableVendor(vendorId:number): Observable<VendorPerson>{
    let body = JSON.stringify(vendorId);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    return this._httpServce.put<VendorPerson>(environment.APIUrl +'/vendor/disablevendor/'+ vendorId,body,options);
  }


  addVendor(vendor: VendorPerson){
    console.log("Service: " +vendor);
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    if(vendor.vendorId)
    {
      return this._httpServce.put(environment.APIUrl +'/vendor/add', body, options);
    }
    else
    {
      return this._httpServce.post(environment.APIUrl +'/vendor/add', body, options);
    }
  }

  getVendorById(vendorId: number): Observable<VendorPerson>{
    return this._httpServce.get<VendorPerson>(environment.APIUrl +'/vendor/view/'+ vendorId);
  }
}
