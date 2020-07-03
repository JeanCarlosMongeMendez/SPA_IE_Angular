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
import { ListCourseComponent } from './components/list-course/list-course.component';
import { UpdateCourseComponent } from './components/update-course/update-course.component';

const appRoutes: Routes = [
  {
    path: 'form-course',
    component: FormCourseComponent,
    data: { title: 'Course Add' }
  },
  {
    path: 'list-course',
    component: ListCourseComponent,
    data: { title: 'List Course' }
  },
  {
    path: 'update-course/:courseId',
    component: UpdateCourseComponent,
    data: { title: 'Update Course' }
  }
];

@NgModule({
  declarations: [
    AppComponent,
  //  CourseComponent,
    FormCourseComponent,
  ListCourseComponent,
  UpdateCourseComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  exports: [
    FormCourseComponent,
    ListCourseComponent,
    UpdateCourseComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
