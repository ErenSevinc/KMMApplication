//
//  MovieDetailView.swift
//  iosApp
//
//  Created by Sevinc, Eren on 1.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieDetailView: View {
    var movieId: Int64?
    @StateObject var viewModel = MovieDetailViewModel()
    
    var body: some View {
        VStack {
            /*
             Text("movie: \(self.viewModel.movieDetailResult.title ?? "Boş")").onAppear() {
             viewModel.load(movieId: movieId!)
             */
            DetailView(item: self.viewModel.movieDetailResult,genres: self.viewModel.genres, companies: self.viewModel.companies).onAppear() {
                viewModel.load(movieId: movieId!)
            }
            
        }.navigationBarTitle("Film Detay", displayMode: .inline)
    }
}

    
    
struct DetailView: View {
    let item: MovieDetailResult
    let genres: String
    let companies: String
    var body: some View {
            VStack {
                VStack {
                    if #available(iOS 15.0, *) {
                        AsyncImage(url: URL(string: "https://www.themoviedb.org/t/p/w500_and_h282_face/\(item.backdropPath ?? "pFlaoHTZeyNkG83vxsAJiGzfSsa.jpg")")) { image in
                            image
                                .resizable()
                                .scaledToFit()
                                .frame(width: .infinity, height:250)
                        } placeholder: {
                            Image("placeholder")
                                .resizable()
                                .scaledToFit()
                                .frame(width: .infinity, height:250)
                        }
                    } else {
                        // Fallback on earlier versions
                    }
                }
                Text("\(item.title ?? "Title")").fontWeight(.bold).padding(8)
                ScrollView {
                    VStack {
                        Text("\(item.tagline ?? "Tagline")").padding(8)
                        Text("\(item.overview ?? "Overview")").padding(8)
                        TitleSetView(title:"Filmin Orjinal Adı", text:"\(item.originalTitle ?? "Original Title")")
                        TitleSetView(title: "Tarih", text: "\(item.releaseDate ?? "Release Date")")
                        TitleSetView(title:"Ortalama Puan", text :"\(item.voteAverage?.stringValue ?? "VoteAverage")")
                        TitleSetView(title:"Kategori", text :"\(genres.dropLast(2))" )
                        TitleSetView(title:"Yapımcı", text :"\(companies.dropLast(2))" )
                    }
                }
            }
        }
}

    
    struct TitleSetView: View {
        var title: String?
        var text: String?
        
        var body: some View {
            VStack {
                Text(title!).fontWeight(.bold).font(.system(size:16))
                Text(text!).multilineTextAlignment(.center).font(.system(size:14))
            }.padding(16)
        }
    }
    
    struct MovieDetailView_Previews: PreviewProvider {
        static var previews: some View {
            MovieDetailView()
        }
    }
