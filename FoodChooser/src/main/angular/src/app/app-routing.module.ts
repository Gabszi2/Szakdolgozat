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


const routes: Routes = [
  {path: '', component: StartPageComponent},
  {path: 'admin', component: AdminChoiceComponent},
  {path: 'admin/food-start', component: AdminFoodStartComponent},
  {path: 'admin/question-start', component: AdminQuestionStartComponent},
  {path:'admin/question-list/:kitchen',component:AdminQuestionListComponent},
  {path:'admin/question-add/:kitchen',component:AdminQuestionAddComponent},
  {path:'admin/question-modify/:kitchen/:question',component:AdminQuestionModifyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
