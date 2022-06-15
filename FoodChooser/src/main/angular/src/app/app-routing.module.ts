import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StartPageComponent} from "./start-page/start-page.component";
import {AdminChoiceComponent} from "./admin-choice/admin-choice.component";
import {AdminFoodStartComponent} from "./admin-food-components/admin-food-start/admin-food-start.component";
import {
  AdminQuestionStartComponent
} from "./admin-question-components/admin-question-start/admin-question-start.component";
import {
  AdminQuestionListComponent
} from "./admin-question-components/admin-question-list/admin-question-list.component";
import {AdminQuestionAddComponent} from "./admin-question-components/admin-question-add/admin-question-add.component";
import {
  AdminQuestionModifyComponent
} from "./admin-question-components/admin-question-modify/admin-question-modify.component";
import {AdminFoodListComponent} from "./admin-food-components/admin-food-list/admin-food-list.component";
import {AdminFoodModifyComponent} from "./admin-food-components/admin-food-modify/admin-food-modify.component";
import {AdminFoodAddComponent} from "./admin-food-components/admin-food-add/admin-food-add.component";
import {
  AdminFoodModifyAnswersComponent
} from "./admin-food-components/admin-food-modify-answers/admin-food-modify-answers.component";
import {
  AdminFoodModifyRestaurantsComponent
} from "./admin-food-components/admin-food-modify-restaurants/admin-food-modify-restaurants.component";
import {
  AdminFoodAddAnswersComponent
} from "./admin-food-components/admin-food-add-answers/admin-food-add-answers.component";
import {
  AdminFoodAddRestaurantsComponent
} from "./admin-food-components/admin-food-add-restaurants/admin-food-add-restaurants.component";


const routes: Routes = [
  {path: '', component: StartPageComponent},
  {path: 'admin', component: AdminChoiceComponent},
  {path: 'admin/food-start', component: AdminFoodStartComponent},
  {path: 'admin/question-start', component: AdminQuestionStartComponent},
  {path:'admin/question-list/:kitchen',component:AdminQuestionListComponent},
  {path:'admin/question-add/:kitchen',component:AdminQuestionAddComponent},
  {path:'admin/question-modify/:kitchen/:question',component:AdminQuestionModifyComponent},
  {path:'admin/food-list/:town/:kitchen',component:AdminFoodListComponent},
  {path:'admin/food-modify/:town/:kitchen/:foodName',component:AdminFoodModifyComponent},
  {path:'admin/food-add/:town/:kitchen',component:AdminFoodAddComponent},
  {path:'admin/food-modify-answers/:town/:kitchen/:foodName',component:AdminFoodModifyAnswersComponent},
  {path:'admin/food-modify-restaurants/:town/:kitchen/:foodName',component:AdminFoodModifyRestaurantsComponent},
  {path:'admin/food-add-answers/:town/:kitchen/:foodName',component:AdminFoodAddAnswersComponent},
  {path:'admin/food-add-restaurants/:town/:kitchen/:foodName',component:AdminFoodAddRestaurantsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
