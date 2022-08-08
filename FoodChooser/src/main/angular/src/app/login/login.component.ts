import {Component, OnInit} from '@angular/core';
import {UserService} from "../services/user.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!:FormGroup;
  constructor(private userService:UserService,private formBuilder:FormBuilder,private router:Router) {
  }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      email: ['',Validators.required],
      password:['',Validators.required],
    })
  }
  async login(){
    const email=this.loginForm.get('email')?.value;
    const password=this.loginForm.get('password')?.value;

    await this.userService.login(email,password)

    if (this.userService.isAdmin()){
      await this.router.navigate(['/admin'])
    }else {
      await this.router.navigate(['/start'])
    }
  }

}
//TODO HTML re-haul
//TODO navbar for admins in HTML
//TODO question for teach about exception handling in angular (massage)+ routing help
