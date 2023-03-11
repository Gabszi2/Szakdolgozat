import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CityModel} from "../models/city-model";
import {lastValueFrom} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AdminCityService {
  adminUrl: string;

  constructor(private http: HttpClient) {
    this.adminUrl = 'http://localhost:8080/admin'
  }

  async addCity(city: CityModel) {
    return lastValueFrom(this.http.post<CityModel>(this.adminUrl + '/city', city));
  }

  async getCity(name: string) {
    return lastValueFrom(this.http.get<CityModel>(this.adminUrl + '/city/' + name));
  }

  async getCities() {
    return lastValueFrom(this.http.get<CityModel[]>(this.adminUrl + '/cities'));
  }

  async deleteCity(name: string) {
    return lastValueFrom(this.http.delete(this.adminUrl + '/city/' + name));
  }

  async updateCity(city: CityModel) {
    return lastValueFrom(this.http.put(this.adminUrl + '/city', city))
  }
}
