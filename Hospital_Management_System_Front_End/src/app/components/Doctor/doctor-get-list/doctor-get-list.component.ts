import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorModel } from 'src/app/models/doctor.model';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doctor-get-list',
  templateUrl: './doctor-get-list.component.html',
  styleUrls: ['./doctor-get-list.component.css']
})
export class DoctorGetListComponent implements OnInit {

  isLoading = false;
  doctorList: DoctorModel[] | undefined;
  doctor: any;

  constructor(private doctorService: DoctorService, private router: Router) { }

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.isLoading = true;
    this.doctorService.getList().subscribe({
      next: (res) => {
        this.doctorList = res;
        this.isLoading = false;
        console.log(this.doctorList);
      },
      error: (error) => {
        console.log(error);
        this.isLoading = false;
      },
    });
  }

  delete(id: any){
    let text= "Do you want to delete the doctor?"
    if(confirm(text)==true){
    this.doctorService.delete(id).subscribe({
      next: (res) =>{
        console.log(res);
        if(res == null){
          alert("Doctor deleted");
          console.log(res);
          this.getList();
          this.router.navigate(["admin/doctor-get-list"]);
        }
      },
    error : (error)=>{
      console.log(error);
      this.isLoading = false;
      console.log(error);
      alert("Doctor can't delete")
    },
  });
}
  }

  edit(id: number){
    localStorage.setItem('id',JSON.stringify(id))
  }

}
