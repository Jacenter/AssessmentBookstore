import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/Book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<Book[]>{
    return this.http.get<Book[]>
    (`http://localhost:8082/api/v1/bookstore`)
  }

  getAllBooksByCategoryId(categoryId: number): Observable<Book[]>{
    return this.http.get<Book[]>
    (`http://localhost:8082/api/v1/bookstore/books/${categoryId}`)
  }

  getAllBooksByCategoryName(categoryName: string): Observable<Book[]>{
    return this.http.get<Book[]>
    (`http://localhost:8082/api/v1/bookstore/books/category/${categoryName}`)
  }

  getAllBooksWithNameContaining(name: string): Observable<Book[]>{
    return this.http.get<Book[]>
    (`http://localhost:8082/api/v1/bookstore/books/names/${name}`)
  }

  getBookById(id:number):Observable<Book>{
    return this.http.get<Book>
    (`http://localhost:8082/api/v1/bookstore/${id}`)
  }


}
