import { Component, OnInit } from '@angular/core';

declare interface RouteInfo{
  path:string;
  title:string;
  class:string;
}
export const ROUTES: RouteInfo[]=[
  {path: 'doctor-add', title: 'Add Doctor',class:''},
  {path: 'doctor-get-list', title: 'Doctor List ',class:''},
  {path: 'patient-add', title: 'Add Patient',class:''},
  {path: 'patient-get-list', title: 'Patient List',class:''},
  {path: 'appointment-add', title: 'Add Appoinment',class:''},
  {path: 'appointment-get-list', title: 'Appoinment List',class:''},
  {path: 'prescription-add', title: 'Add Prescription', class:''},
  {path: 'prescription-get-list', title: 'Prescription List', class:''},
];
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems : any;
  constructor() { }

  ngOnInit(): void {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }


}
