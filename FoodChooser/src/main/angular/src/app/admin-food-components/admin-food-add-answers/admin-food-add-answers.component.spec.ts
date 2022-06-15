import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFoodAddAnswersComponent } from './admin-food-add-answers.component';

describe('AdminFoodAddAnswersComponent', () => {
  let component: AdminFoodAddAnswersComponent;
  let fixture: ComponentFixture<AdminFoodAddAnswersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFoodAddAnswersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFoodAddAnswersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
