import { HttpClient ,HttpParams ,HttpHeaders} from '@angular/common/http';
import { Type } from '@angular/compiler';
import { Injectable } from '@angular/core';
import jwtDecode from 'jwt-decode';
import { Observable, map, of } from 'rxjs';

const AUTH_API = 'http://localhost:8098/api/v1/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export  class AuthService {

  constructor(private http : HttpClient) { }
   isAuthenticated : boolean = false;
   roles :any;
   username :any;
   accessToken !: string;

  login(username: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'signin',
      {
        username,
        password,
      },
      httpOptions
    );
  }
  
  register(username: string, email: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'signup',
      {
        username,
        email,
        password,
      },
      httpOptions
    );
  }

  logout(): Observable<boolean> {
      this.isAuthenticated = false;
      this.username ="";
      this.accessToken ="";
 
      return of(true);
  }

  loadProfil(data:any){
    this.isAuthenticated = true ;
    this.accessToken = data['accessToken'];
    let decodedJwt : any = jwtDecode(this.accessToken);
    this.username = decodedJwt.sub;
    this.roles = decodedJwt.scope;
  }


    /*let options={
      //headers : new HttpHeaders().set("Content-Type","application/x-www-form-urlencoded")
      headers : new HttpHeaders().set("Content-Type","application/json")
    }
    let params = new HttpParams();
    return this.http.post("http://localhost:8098/api/v1/auth/signin", params, options)
    
    */
  
  
}
