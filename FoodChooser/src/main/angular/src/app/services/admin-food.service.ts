import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FoodModel} from "../models/food-model";
import {lastValueFrom} from "rxjs";
import {CityModel} from "../models/city-model";

@Injectable({
  providedIn: 'root'
})
export class AdminFoodService {

  adminUrl: string;

  constructor(private http: HttpClient) {
    this.adminUrl = 'http://localhost:8080/admin'
  }

  async getAllFood(town: string, cuisine: string) {
    return lastValueFrom(this.http.get<FoodModel[]>(this.adminUrl + '/foods/' + town + '/' + cuisine));
  }

  async getFood(town: string, cuisine: string, foodName: string) {
    return lastValueFrom(this.http.get<FoodModel>(this.adminUrl + '/food/' + town + '/' + cuisine + '/' + foodName))
  }

  async deleteFood(town: string, cuisine: string, food: FoodModel) {
    return lastValueFrom(this.http.delete(this.adminUrl + '/food/' + town + '/' + cuisine, {body: food}));
  }

  async addFood(town: string, cuisine: string, food: FoodModel) {

    return lastValueFrom(this.http.post<FoodModel>(this.adminUrl + '/food/' + town + '/' + cuisine, food));
  }

  async updateFood(town: string, cuisine: string, food: FoodModel) {
    return lastValueFrom(this.http.put(this.adminUrl + '/food/' + town + '/' + cuisine, food));
  }
  async getCities(){
    return lastValueFrom(this.http.get<CityModel[]>(this.adminUrl+'/cities'));
  }
}
