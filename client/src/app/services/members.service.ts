import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IMember } from '../members-list/members-list.component';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MembersService {

  private _url: string = 'http://localhost:8080/api/v1/users'

  constructor(private http:HttpClient) { }

  getMembers():Observable<IMember[]>{
    return this.http.get<IMember[]>(this._url);
  }
}
