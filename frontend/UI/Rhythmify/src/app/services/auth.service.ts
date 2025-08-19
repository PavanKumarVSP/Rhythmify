import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


export interface LoginRequest{
  userEmail:string;
  userName:string;
  userPassword:string;
}

export interface RegisterRequest{
  userName:string;
  userPassword:string;
  userMobileNumber:string;
  userEmail:string;
}

export interface userObject{
  userName:string;
  userPassword:string;
  userMobileNumber:string;
  userEmail:string;
  userId:string;
}


@Injectable({
  providedIn: 'root'
})

export class AuthService {

  public currentUser : userObject | null = null;

  private baseUrl="http://localhost:8080/api/auth";

  constructor(private http: HttpClient) {  }

  login(request:LoginRequest):Observable<any>{
    return this.http.post(`${this.baseUrl}/login`,request);
  }

  register(request:RegisterRequest):Observable<any>{
    console.log("Request ",request)
    return this.http.post(`${this.baseUrl}/create-user`,request);
  }

  setUser(user: userObject) {
    console.log("Saved Current User Details in Auth Service ")
    this.currentUser = user;
  }

  getUser(): userObject | null {
    return this.currentUser;
  }


}
