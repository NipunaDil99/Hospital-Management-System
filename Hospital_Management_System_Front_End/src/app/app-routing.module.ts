import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLayoutComponent } from './components/layout/admin-layout/admin-layout.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DoctorAddComponent } from './components/Doctor/doctor-add/doctor-add.component';
import { DoctorUpdateComponent } from './components/Doctor/doctor-update/doctor-update.component';
import { DoctorGetListComponent } from './components/Doctor/doctor-get-list/doctor-get-list.component';
import { AppointmentAddComponent } from './components/appointment/appointment-add/appointment-add.component';
import { AppointmentGetListComponent } from './components/appointment/appointment-get-list/appointment-get-list.component';
import { AppointmentUpdateComponent } from './components/appointment/appointment-update/appointment-update.component';
import { PrescriptionAddComponent } from './components/prescription/prescription-add/prescription-add.component';
import { PrescriptionUpdateComponent } from './components/prescription/prescription-update/prescription-update.component';
import { PrescriptionGetListComponent } from './components/prescription/prescription-get-list/prescription-get-list.component';
import { PatientAddComponent } from './components/patient/patient-add/patient-add.component';
import { PatientGetListComponent } from './components/patient/patient-get-list/patient-get-list.component';
import { PatientUpdateComponent } from './components/patient/patient-update/patient-update.component';


const routes: Routes = [

  { path: '', redirectTo: 'admin', pathMatch: 'full' },
  {
    path: 'admin',
    component: AdminLayoutComponent,
    children: [
      { path: 'doctor-get-list', component: DoctorGetListComponent},
      { path: 'doctor-add', component: DoctorAddComponent},
      { path: 'doctor-update', component: DoctorUpdateComponent},
      { path: 'dashboard', component: DashboardComponent },
      { path: 'appointment-add', component: AppointmentAddComponent },
      { path: 'appointment-get-list', component: AppointmentGetListComponent },
      { path: 'appointment-update', component: AppointmentUpdateComponent },
      { path: 'prescription-add', component: PrescriptionAddComponent },
      { path: 'prescription-get-list',component: PrescriptionGetListComponent },
      { path: 'prescription-update', component: PrescriptionUpdateComponent },
      { path: 'patient-add', component:PatientAddComponent},
      { path: 'patient-get-list', component:PatientGetListComponent},
      { path: 'patient-update', component:PatientUpdateComponent},
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    ],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
