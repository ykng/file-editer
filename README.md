fileEditer
===============

**ArffCutter**
arffファイルから部分的に情報を切り取るためのクラス
arffファイルからトレースデータの成分を抜き取り、notglsのarffファイルを生成するためのもの

**ArffEditer**
notglsのarffファイルに、トレースデータの成分を挿入するクラス
役割的にはArffCutterと逆

**ClassSorting**
トレースデータをロードした時の出力の各メソッドについて実行時間クラスで分類して別々のファイルに保存

**FileCutting**
トレースデータをロードした際に、最後に出力される各実行時間クラスのメソッド数をarffファイルにappendする形で保存

**FilesCutting**
FilesCuttingの機能に、hibench.reportの最終行の情報を追加する機能がついているクラス

**ForWekaPrediction**
Wekaで出力されたcsvファイルから予測値だけ抜き出すクラス

**TFCForSlave**
TwoFilesCuttingのスレーブノード版

**TwoFilesCutting**
hadoopの出力から実行時間とトレースデータから実行時間クラスの情報を抽出するクラス
