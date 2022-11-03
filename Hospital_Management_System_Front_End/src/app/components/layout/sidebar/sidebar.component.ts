import { Component, OnInit } from '@angular/core';

declare interface RouteInfo{
  path:string;
  title:string;
  class:string;
}
export const ROUTES: RouteInfo[]=[
  {path: 'doctor-add', title: 'Add Doctor',class:''},
  {path: 'doctor-update', title: 'Update Doctor',class:''},
  {path: 'doctor-get-list', title: 'Doctor List ',class:''}

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
