import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFoodStartComponent } from './admin-food-start.component';

describe('AdminFoodStartComponent', () => {
  let component: AdminFoodStartComponent;
  let fixture: ComponentFixture<AdminFoodStartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFoodStartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFoodStartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
