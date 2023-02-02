import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";
import {UserModel} from "../models/user-model";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;

  constructor(private userService: UserService, private formBuilder: FormBuilder, private router: Router) {
  }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', Validators.required],
      userName: ['', Validators.required],
      password: ['', Validators.required],
    })
  }

  async register() {
    const user = <UserModel>{};
    user.email = this.registerForm.get('email')?.value;
    user.userName = this.registerForm.get('userName')?.value;
    user.password = this.registerForm.get('password')?.value;
    user.admin = false;

    await this.userService.register(user);
    await this.router.navigate(['/login'])
  }

}
