from PySide2 import QtWidgets
from PySide2 import QtGui
from PySide2 import QtCore
from shutil import copy
import os



#import test
from ui import main
class MyFileBrowser(main.Ui_MainWindow, QtWidgets.QMainWindow):
    def __init__(self, maya=False):
        super(MyFileBrowser, self).__init__()
        self.setupUi(self)
        self.maya = maya
        self.treeView.setContextMenuPolicy(QtCore.Qt.CustomContextMenu)
        self.treeView.customContextMenuRequested.connect(self.context_menu)
        self.populate()

    def populate(self):
        path = r"C:\Users\Alexandr\.PyCharmCE2018.3\config\scratches\waiting"
        self.model = QtWidgets.QFileSystemModel()
        self.model.setRootPath((QtCore.QDir.rootPath()))
        self.treeView.setModel(self.model)
        self.treeView.setRootIndex(self.model.index(path))
        self.treeView.setSortingEnabled(True)

    def context_menu(self):
        menu = QtWidgets.QMenu()
        open = menu.addAction("Open WITH")
        copy = menu.addAction("pass the file")
        open.triggered.connect(self.open_file)
        copy.triggered.connect(self.copy_file)
        if self.maya:
            open_file = menu.addAction("Open file")
            open_file.triggered.connect(lambda: self.maya_file_operations(open_file=True))

        cursor = QtGui.QCursor()
        menu.exec_(cursor.pos())

    def open_file(self):
        index = self.treeView.currentIndex()
        file_path = self.model.filePath(index)
        os.startfile(file_path)
    def copy_file(self):
        copy(r"C:\Users\Alexandr\.PyCharmCE2018.3\config\scratches\waiting\Sunday_18_10_2020_04_44_48", r"C:\Users\Alexandr\.PyCharmCE2018.3\config\scratches\passed")


if __name__ == '__main__':
    app = QtWidgets.QApplication([])
    fb = MyFileBrowser()
    fb.show()
    app.exec_()