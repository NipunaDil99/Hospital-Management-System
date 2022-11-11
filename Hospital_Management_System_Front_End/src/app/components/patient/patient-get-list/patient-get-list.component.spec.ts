import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientGetListComponent } from './patient-get-list.component';

describe('PatientGetListComponent', () => {
  let component: PatientGetListComponent;
  let fixture: ComponentFixture<PatientGetListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientGetListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientGetListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
