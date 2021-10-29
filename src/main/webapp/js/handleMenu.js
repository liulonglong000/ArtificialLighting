function menuNeedChange(srcId, destId) {
	var addA = self.parent.frames['menu'].document.getElementById(srcId);
	addA.className = "";
	var queryA = self.parent.frames['menu'].document.getElementById(destId);
	queryA.className = "active";
}