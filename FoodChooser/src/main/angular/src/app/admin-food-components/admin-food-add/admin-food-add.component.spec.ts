import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AdminFoodAddComponent} from './admin-food-add.component';

describe('AdminFoodAddComponent', () => {
  let component: AdminFoodAddComponent;
  let fixture: ComponentFixture<AdminFoodAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminFoodAddComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFoodAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
