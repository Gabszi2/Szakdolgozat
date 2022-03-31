import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StartPageComponent} from "./start-page/start-page.component";
import {AdminChoiceComponent} from "./admin-choice/admin-choice.component";
import {AdminFoodStartComponent} from "./admin-food-components/admin-food-start/admin-food-start.component";
import {
  AdminQuestionStartComponent
} from "./admin-question-components/admin-question-start/admin-question-start.component";


const routes: Routes = [
  {path: '', component: StartPageComponent},
  {path: 'admin', component: AdminChoiceComponent},
  {path: 'admin/food-start', component: AdminFoodStartComponent},
  {path: 'admin/question-start', component: AdminQuestionStartComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
