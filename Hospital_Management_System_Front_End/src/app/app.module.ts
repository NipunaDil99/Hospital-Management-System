import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/layout/header/header.component';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutComponent } from './components/layout/admin-layout/admin-layout.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { SidebarComponent } from './components/layout/sidebar/sidebar.component';
import { NavbarComponent } from './components/layout/navbar/navbar.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DoctorAddComponent } from './components/Doctor/doctor-add/doctor-add.component';
import { DoctorUpdateComponent } from './components/Doctor/doctor-update/doctor-update.component';
import { DoctorGetListComponent } from './components/Doctor/doctor-get-list/doctor-get-list.component';
import { AppointmentAddComponent } from './components/appointment/appointment-add/appointment-add.component';
import { AppointmentGetListComponent } from './components/appointment/appointment-get-list/appointment-get-list.component';
import { AppointmentUpdateComponent } from './components/appointment/appointment-update/appointment-update.component';
import { PatientAddComponent } from './components/patient/patient-add/patient-add.component';
import { PatientGetListComponent } from './components/patient/patient-get-list/patient-get-list.component';
import { PatientUpdateComponent } from './components/patient/patient-update/patient-update.component';
import { PrescriptionAddComponent } from './components/prescription/prescription-add/prescription-add.component';
import { PrescriptionGetListComponent } from './components/prescription/prescription-get-list/prescription-get-list.component';
import { PrescriptionUpdateComponent } from './components/prescription/prescription-update/prescription-update.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AdminLayoutComponent,
    FooterComponent,
    SidebarComponent,
    NavbarComponent,
    DashboardComponent,
    DoctorAddComponent,
    DoctorUpdateComponent,
    DoctorGetListComponent,
    AppointmentAddComponent,
    AppointmentGetListComponent,
    AppointmentUpdateComponent,
    PatientAddComponent,
    PatientGetListComponent,
    PatientUpdateComponent,
    PrescriptionAddComponent,
    PrescriptionGetListComponent,
    PrescriptionUpdateComponent
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule,ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
