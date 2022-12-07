import java.io.File;

fun main() {
    // Create map of all directories
    var directories = mutableMapOf<String,Directory>()
    // Scan input data
    // > track pwd path and keep reference to directory object of pwd
    var pwd = Directory("null")
    var pwdPath = "/"
    // > loop over input lines
    File("input.dat").forEachLine { line ->
        val cmd = line.split(' ')
        if (cmd.size < 1) 
        // Look for cd command command
        else if ( cmd[0] == "$" && cmd[1] == "cd" ) {
            var dirName = cmd[2]
            // change pwd
            if (dirName == "/") pwdPath = "root"
            else if (dirName == "..") pwdPath = pwdPath.dropLastWhile{ it != '/' }.dropLast(1)
            else pwdPath += "/" + dirName
            pwd = directories.getOrPut( pwdPath, {Directory(pwdPath)} )
        }
        // Can ignore ls, if we see directories listed, assume ls has been issued
        else if ( cmd[0] == "$" )
        // Look for listed directories
        else if ( cmd[0] == "dir" ) {
            // Find path, register in dictionary, and add as a subdirectory to pwd
            val dirPath = "$pwdPath/${cmd[1]}"
            val dir = directories.getOrPut( dirPath, {Directory(dirPath)} )
            pwd.AddSubdir( dir )
        }
        // Look for listed files (only remaining case)
        else {
            // Add file to pwd
            pwd.AddFile( name=cmd[1], size=cmd[0].toInt() )
        }
    }
    // Calculate quantities for solutions
    // > part 1 sum
    var smallDirSum = 0
    // > part 2 smallest directory to delete
    var usedSpace = directories["root"]!!.Size()
    var spaceNeeded = usedSpace - (70000000-30000000)
    var toDelete = usedSpace // starting value
    // > loop over directories
    directories.forEach{ name, dir ->
        val size = dir.Size()
        println( "$name: $size" )
        if (size < 100000) smallDirSum += size
        if (size >= spaceNeeded && size < toDelete) toDelete = size
    }
    // > print solutions
    println("Part 1 Answer: $smallDirSum")
    println("Part 2 Answer: $toDelete")
}

// Directory class
class Directory( val name: String ) {
    var subdirs = mutableListOf<Directory>()
    var files = mutableMapOf<String,Int>()
    var size : Int? = null

    fun AddSubdir( name: String ): Directory {
        var newDir = Directory(name)
        this.subdirs.add(newDir)
        return newDir
    }

    fun AddSubdir( dir: Directory ) {
        // check if subdirectory already added
        var exists = false
        for ( subdir in this.subdirs ) {
            if ( subdir.name == dir.name ) exists = true
        }
        // else add it
        if (!exists) this.subdirs.add(dir)
    }

    fun AddFile( name: String, size: Int ) {
        this.files.put( name, size )
    }

    fun Size(): Int {
        // use stored this.size to avoid repeat computation
        if (this.size == null) 
        {
            var size = 0
            // Add up files in this directory
            this.files.forEach{ _, fileSize -> size += fileSize }
            // Call size calculation on subdirectories
            this.subdirs.forEach{ subDir -> size += subDir.Size() }
            this.size = size
        }
        return this.size!!
    }
}
