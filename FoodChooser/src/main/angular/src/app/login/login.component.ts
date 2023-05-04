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
  loginForm!: FormGroup;

  constructor(private userService: UserService, private formBuilder: FormBuilder, private router: Router) {
  }

  ngOnInit(): void {
    if (this.userService.isLoggedIn()) {
      this.userService.logout()
    }

    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required,Validators.email]],
      password: ['', Validators.required],
    })
  }

  async login() {
    const email = this.loginForm.get('email')?.value;
    const password = this.loginForm.get('password')?.value;

    await this.userService.login(email, password)

    if (this.userService.isAdmin()) {
      await this.router.navigate(['/admin']).then(() => {
        window.location.reload()
      })
    } else {
      await this.router.navigate(['/start']).then(() => {
        window.location.reload()
      })
    }
  }

}



