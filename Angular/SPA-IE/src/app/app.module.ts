import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//import { CourseComponent } from './components/course/course.component';
import { Observable } from 'rxjs';
import { FormCourseComponent } from './components/form-course/form-course.component';
import { GridModule } from '@progress/kendo-angular-grid';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProfessorListComponent } from './components/professor-list/professor-list.component';



const appRoutes: Routes = [
  {
    path: 'form-course',
    component: FormCourseComponent,
    data: { title: 'Course Add' }
  },

];

@NgModule({
  declarations: [
    AppComponent,
  //  CourseComponent,
    FormCourseComponent,
  ProfessorListComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    GridModule,
    BrowserAnimationsModule
  ],
  exports: [
    FormCourseComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
