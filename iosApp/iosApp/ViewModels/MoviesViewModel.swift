//
//  MoviesViewModel.swift
//  iosApp
//
//  Created by Sevinc, Eren on 29.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class MoviesViewModel: ObservableObject {
    
    private let moviesUseCase: GetPopularMoviesUseCase = koin.getPopularMoviesUseCase()
    //var movieResult = MoviesResult(page: nil, totalResults: nil, totalPages: -1, results: NSMutableArray())
    @Published var movieItemList: [MovieItem] = []
    @Published var isSuccess: IsSuccess = IsSuccess.loading
    @Published var pageCnt : KotlinLong = 5
    
    var item = MovieItem(id:nil,posterPath: nil, adult: nil, overview: nil,releaseDate: nil,genreIds: NSMutableArray(), originalTitle: nil, originalLanguage: nil, title: nil,backdropPath: nil,popularity: nil,voteCount: nil, video: nil, voteAverage: nil)
    
    init() {
        load()
    }

     

    func load() {
        moviesUseCase.getPopularMovies { result, error in
            if let result = result {
                self.isSuccess = IsSuccess.success
                self.movieItemList = result.results as! [MovieItem]
                self.pageCnt = result.page ?? -1
            }
            else {
                self.isSuccess = IsSuccess.fail
            }
        }
    }
}
