import {Component, OnInit} from '@angular/core';
import {UserService} from "../services/user.service";
import {UserModel} from "../models/user-model";

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css']
})
export class AdminUsersComponent implements OnInit {
  userAll!: UserModel[];
  // @ts-ignore
  currentUser = JSON.parse(localStorage.getItem('user')) as UserModel;

  constructor(private service: UserService) {
  }

  async ngOnInit() {
    this.userAll = await this.service.getAllUsers();
  }

  async delete(user: UserModel) {
    if (user.email != this.currentUser.email) {
      await this.service.deleteUser(user.email, user.password);
      this.userAll = await this.service.getAllUsers();
    } else {
      alert("You can't delete yourself!")
    }
  }

  async updateAdmin(user: UserModel) {
    if (user.email != this.currentUser.email) {
      await this.service.updateUserAdmin(user.email, user.password);
      this.userAll = await this.service.getAllUsers();
    } else {
      alert("You can't change your own Admin status!")
    }
  }
}
