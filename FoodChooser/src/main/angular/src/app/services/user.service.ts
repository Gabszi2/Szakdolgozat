import { Injectable } from '@angular/core';
import {lastValueFrom} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {UserModel} from "../models/user-model";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class UserService {
userUrl:string;
  private currentUser?: UserModel ;


  constructor(private http: HttpClient, private router: Router) {
    this.userUrl='http://localhost:8080/'
  }


  async login(email:string,password:string){
const user= await lastValueFrom(this.http.get<UserModel>(this.userUrl+'login/'+email+'/'+password));
    this.currentUser =  user;

    localStorage.setItem('user',JSON.stringify(user));
  }

  async register(user:UserModel){
    return lastValueFrom(this.http.post<UserModel>(this.userUrl+'register',user))
  }

  isLoggedIn() {
    if (!localStorage.getItem('user')) {
      return false;
    }
    return true;
  }

  isAdmin() {
    const userS=localStorage.getItem('user');
    let userO:UserModel;
    if (userS){

      userO=JSON.parse(userS);
      return userO.admin;
    }
    return false;
  }

  logout() {
    this.currentUser = undefined;
    localStorage.clear();
    this.router.navigate(['/login']).then(()=>{window.location.reload()});
  }

}
