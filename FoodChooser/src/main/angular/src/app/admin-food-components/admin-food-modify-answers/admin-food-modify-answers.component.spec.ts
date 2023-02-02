import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AdminFoodModifyAnswersComponent} from './admin-food-modify-answers.component';

describe('AdminFoodModifyAnswersComponent', () => {
  let component: AdminFoodModifyAnswersComponent;
  let fixture: ComponentFixture<AdminFoodModifyAnswersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminFoodModifyAnswersComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFoodModifyAnswersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
