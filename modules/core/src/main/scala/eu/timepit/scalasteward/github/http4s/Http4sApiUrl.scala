/*
 * Copyright 2018 scala-steward contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.timepit.scalasteward.github.http4s

import cats.MonadError
import eu.timepit.scalasteward.github.{ApiUrl, GitHubRepo}
import org.http4s.Uri

object Http4sApiUrl {
  def forks[F[_]](repo: GitHubRepo)(implicit F: MonadError[F, Throwable]): F[Uri] =
    fromString(ApiUrl.forks(repo))

  def pulls[F[_]](repo: GitHubRepo)(implicit F: MonadError[F, Throwable]): F[Uri] =
    fromString(ApiUrl.pulls(repo))

  def fromString[F[_]](s: String)(implicit F: MonadError[F, Throwable]): F[Uri] =
    F.fromEither(Uri.fromString(s))
}
