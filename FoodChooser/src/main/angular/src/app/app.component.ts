import {Component} from '@angular/core';
import {UserService} from "./services/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular';
  admin!: boolean

  constructor(private service: UserService) {
  }

  ngOnInit(): void {
    this.admin = this.service.isAdmin()
  }
//TODO átnevezni a kitchent cuisine-re és általánosítani a változóneveket
}
