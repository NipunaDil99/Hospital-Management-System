import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLayoutComponent } from './components/layout/admin-layout/admin-layout.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DoctorAddComponent } from './components/Doctor/doctor-add/doctor-add.component';
import { DoctorUpdateComponent } from './components/Doctor/doctor-update/doctor-update.component';
import { DoctorGetListComponent } from './components/Doctor/doctor-get-list/doctor-get-list.component';


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
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    ],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
