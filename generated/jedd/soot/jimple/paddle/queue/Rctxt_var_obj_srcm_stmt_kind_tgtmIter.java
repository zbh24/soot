package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rctxt_var_obj_srcm_stmt_kind_tgtmIter extends Rctxt_var_obj_srcm_stmt_kind_tgtm {
    protected Iterator r;
    
    public Rctxt_var_obj_srcm_stmt_kind_tgtmIter(Iterator r, String name) {
        super(name);
        this.r = r;
    }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() {
                boolean ret = r.hasNext();
                return ret;
            }
            
            public Object next() {
                return new Tuple((Context) r.next(),
                                 (VarNode) r.next(),
                                 (AllocNode) r.next(),
                                 (SootMethod) r.next(),
                                 (Unit) r.next(),
                                 (Kind) r.next(),
                                 (SootMethod) r.next());
            }
            
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { ctxt.v(), var.v(), obj.v(), srcm.v(), stmt.v(), kind.v(), tgtm.v() },
                                              new PhysicalDomain[] { V2.v(), V1.v(), H1.v(), T1.v(), ST.v(), FD.v(), T2.v() },
                                              ("<soot.jimple.paddle.bdddomains.ctxt:soot.jimple.paddle.bdddo" +
                                               "mains.V2, soot.jimple.paddle.bdddomains.var:soot.jimple.padd" +
                                               "le.bdddomains.V1, soot.jimple.paddle.bdddomains.obj:soot.jim" +
                                               "ple.paddle.bdddomains.H1, soot.jimple.paddle.bdddomains.srcm" +
                                               ":soot.jimple.paddle.bdddomains.T1, soot.jimple.paddle.bdddom" +
                                               "ains.stmt:soot.jimple.paddle.bdddomains.ST, soot.jimple.padd" +
                                               "le.bdddomains.kind:soot.jimple.paddle.bdddomains.FD, soot.ji" +
                                               "mple.paddle.bdddomains.tgtm:soot.jimple.paddle.bdddomains.T2" +
                                               "> ret = jedd.internal.Jedd.v().falseBDD(); at /home/research" +
                                               "/ccl/olhota/soot-trunk/src/soot/jimple/paddle/queue/Rctxt_va" +
                                               "r_obj_srcm_stmt_kind_tgtmIter.jedd:46,70-73"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next(), r.next(), r.next(), r.next(), r.next() },
                                                       new Attribute[] { ctxt.v(), var.v(), obj.v(), srcm.v(), stmt.v(), kind.v(), tgtm.v() },
                                                       new PhysicalDomain[] { V2.v(), V1.v(), H1.v(), T1.v(), ST.v(), FD.v(), T2.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { stmt.v(), srcm.v(), tgtm.v(), var.v(), ctxt.v(), obj.v(), kind.v() },
                                                   new PhysicalDomain[] { ST.v(), T1.v(), T2.v(), V1.v(), V2.v(), H1.v(), FD.v() },
                                                   ("return ret; at /home/research/ccl/olhota/soot-trunk/src/soot" +
                                                    "/jimple/paddle/queue/Rctxt_var_obj_srcm_stmt_kind_tgtmIter.j" +
                                                    "edd:50,8-14"),
                                                   ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}