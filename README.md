# Product:Java Spring CRUD Sample

Spring Boot を用いて作成した、シンプルな CRUD（Create / Read / Update / Delete）機能を持つ商品管理アプリケーションです。  
Java のバックエンド開発学習のアウトプットとして作成しました。

## 概要

このアプリは、商品情報を登録・一覧表示・更新・削除できる基本的な Web アプリケーションです。  
主に以下の目的で作成しました。

- Spring Boot を用いた Web アプリケーション開発の流れを理解する
- MVC モデルの役割分担を意識して実装する
- データベースと連携した CRUD 処理を実装する
- Controller / Service / Repository の責務分離を学ぶ
- Thymeleaf を用いた画面表示の基本を学ぶ

## 使用技術

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MariaDB
- Maven

## 主な機能

- 商品一覧表示
- 商品詳細表示
- 商品登録
- 商品編集
- 商品削除

## 管理対象データ

商品データとして、以下のような項目を扱っています。

- ID
- 商品名
- 価格

※ 実装時点では、シンプルな CRUD 学習を目的としているため、項目は最小限にしています。

## 画面構成

本アプリは以下のような画面構成を想定しています。

1. 商品一覧画面  
   - 登録済み商品の一覧を表示
   - 詳細画面や編集画面への遷移が可能

2. 商品登録画面  
   - 新しい商品情報を入力して登録

3. 商品編集画面  
   - 既存の商品情報を更新

4. 商品削除機能  
   - 一覧画面などから対象商品を削除

## アプリケーション構成

本プロジェクトは、Spring の一般的なレイヤー構成を意識して作成しています。

- **Controller**  
  リクエストを受け取り、画面遷移や Service 呼び出しを担当

- **Service**  
  業務ロジックを担当

- **Repository**  
  データベースアクセスを担当

- **Entity**  
  商品テーブルに対応するデータ構造を定義

- **View (Thymeleaf)**  
  HTML テンプレートを用いて画面表示を担当

## 学習ポイント

このアプリを作成する中で、特に以下の点を意識しました。

- Spring Boot によるアプリ起動の仕組み
- HTTP リクエストと画面遷移の流れ
- MVC に基づいた責務分離
- JPA を使ったデータ永続化
- Thymeleaf によるサーバーサイドレンダリング
- CRUD 処理の一連の流れ
- フォーム入力から DB 更新までのデータ連携

## 今後の改善案

現時点では基本的な CRUD 実装が中心ですが、今後は以下のような機能追加・改善も考えられます。

- バリデーション機能の追加
- 例外処理の強化
- 検索機能の追加
- ページネーション対応
- ログイン機能の安定実装
- Spring Security を用いた認証・認可の改善
- UI/UX の改善

## 実行方法

1. リポジトリをクローン

git clone https://github.com/user-Jai/java-spring-crud-sample.git

3. IDEで開く

IntelliJ IDEA や Eclipse などの Java 対応 IDE でプロジェクトを開きます。

3. データベースを作成

MariaDB 側で使用するデータベースを作成してください。
その後、application.properties または application.yml の接続設定を、自身のローカル環境に合わせて変更してください。

設定例:

spring.datasource.url=jdbc:mariadb://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


4. アプリケーションを起動

IDE から Spring Boot アプリケーションを実行します。
起動後、ブラウザで以下のURLにアクセスしてください。

http://localhost:8080/


制作背景

このプロジェクトは、Java / Spring Boot の学習内容を実際に形にするために作成しました。
単なる文法学習だけでなく、実際に Web アプリとして動くものを作ることで、以下の理解を深めることを目的としています。

Web アプリ全体の処理の流れ
バックエンドとデータベースのつながり
開発現場で使われる基本的な設計の考え方


補足

本リポジトリはポートフォリオおよび学習記録として公開しています。
まだ改善の余地はありますが、基礎的な CRUD 実装を通して、Java バックエンド開発の土台を理解するためのプロジェクトとして作成しました。
