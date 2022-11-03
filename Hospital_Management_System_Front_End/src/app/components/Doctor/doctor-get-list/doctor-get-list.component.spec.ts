import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorGetListComponent } from './doctor-get-list.component';

describe('DoctorGetListComponent', () => {
  let component: DoctorGetListComponent;
  let fixture: ComponentFixture<DoctorGetListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorGetListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorGetListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
