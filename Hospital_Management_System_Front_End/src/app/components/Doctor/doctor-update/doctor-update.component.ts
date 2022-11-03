import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doctor-update',
  templateUrl: './doctor-update.component.html',
  styleUrls: ['./doctor-update.component.css']
})
export class DoctorUpdateComponent implements OnInit {

  id! : number;
  isUpdating = false;
  doctor : any ;
  constructor(private doctorService:DoctorService, private router:Router) { }

  ngOnInit(): void {
    this.id = JSON.parse(localStorage.getItem('id') || '{}');
    this.doctorService.getDoctor(this.id).subscribe({
      next: (res)=>{
        this.doctor = res;
        console.log(this.doctor.id);
      },
      error : (error)=>{
        console.log(error);
      },

    });
  }

  onSubmit() {
    console.log(this.doctor);
    this.isUpdating = true;

    this.doctorService.update(this.id,this.doctor).subscribe({
      next: (res) => {
        if(res){
          this.isUpdating = false;
          alert("Doctor Details Updated");
          console.log('response: ' + res);
          this.router.navigate(["admin/doctor-get-list"]);
        }
      },
      error: (err) => {
        this.isUpdating = false;
        console.log('Error: ' + err);
        alert("Doctor Details not updated...!")
      },
    });


  }

}
